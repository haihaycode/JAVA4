package CodeDao;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class LikeAndCommentFirstPost {
    static String userAccessToken = "EAABwzLixnjYBO3tAicZAKgRZBQxiT6hvHGxRJlXcfasf9TkjIL3yftRn5sBe69N4ePZCry1kIOKF3W80Ot0aUmmfAySzqf1YxuMgQrnuXDjjc0C59S3A8TJsV3uzs6ANeQvSB5tGAZCO0IgHm8ZBECVNCDZBU6oXwe8odAlR41ziHaE8XqG7UZCw1nDPhiFAbb2A5G7IVkO2lZCH";

    public static void main(String[] args) {
        try {
            List<String> friendIds = getFriendIds(userAccessToken);
            for (String friendId : friendIds) {
                String firstPostId = getFirstPostId(friendId, userAccessToken);
                if (firstPostId != null) {
                    likeAndCommentOnPost(firstPostId, userAccessToken);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getFriendIds(String userAccessToken) throws ClientProtocolException, IOException {
        List<String> friendIds = new ArrayList<>();
        String friendListUrl = "https://graph.facebook.com/me/friends?access_token=" + userAccessToken;

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(new HttpGet(friendListUrl));

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray friendData = jsonResponse.getJSONArray("data");
            for (int i = 0; i < friendData.length(); i++) {
                JSONObject friend = friendData.getJSONObject(i);
                String friendId = friend.getString("id");
                friendIds.add(friendId);
            }
        } else {
            System.out.println("Error fetching friend list. Status code: " + statusCode);
        }
        return friendIds;
    }

    public static String getFirstPostId(String friendId, String userAccessToken) throws ClientProtocolException, IOException {
        String postUrl = "https://graph.facebook.com/" + friendId + "/feed?access_token=" + userAccessToken;

        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(new HttpGet(postUrl));

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONArray postData = jsonResponse.getJSONArray("data");
            if (postData.length() > 0) {
                JSONObject firstPost = postData.getJSONObject(0);
                return firstPost.getString("id");
            }
        } else {
            System.out.println("Error fetching friend's post. Status code: " + statusCode);
        }
        return null;
    }

    public static void likeAndCommentOnPost(String postId, String userAccessToken) throws ClientProtocolException, IOException {
        String likeUrl = "https://graph.facebook.com/" + postId + "/likes?access_token=" + userAccessToken;
        String commentUrl = "https://graph.facebook.com/" + postId + "/comments?access_token=" + userAccessToken;

        HttpClient httpClient = HttpClients.createDefault();

        // Like the post
        HttpPost likePost = new HttpPost(likeUrl);
        httpClient.execute(likePost);

        // Comment on the post
        HttpPost commentPost = new HttpPost(commentUrl);
        StringEntity commentEntity = new StringEntity("{\"message\":\"This is a comment.\"}");
        commentEntity.setContentType("application/json");
        commentPost.setEntity(commentEntity);
        httpClient.execute(commentPost);
    }
}
