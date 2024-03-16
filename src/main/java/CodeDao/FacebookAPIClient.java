package CodeDao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookAPIClient {
    public static void main(String[] args) {
        // Access token của người dùng
        String userAccessToken = 
            "EAABwzLixnjYBO0yBZAQZBgALtPJwZAs2ADTMm4w903QIPz8KOGkMMqZB6Af1ZC7upyuB7QmEt1FS8fdQvd2JamMKfEhALSMTuhzcZA8Dg7brt8y5ncqgyZC9flZBKz9oFv59j6gPIKf88TvN6Qt8qEYpZAGMYZBwfro6ElhgRegltR0MRnCONqaYunisyHKoSCZC2ZArSDJFZAWjizOTe";
        // ID của bài viết bạn muốn like
        String postId = "pfbid02X9tAVueAnC9JdKkJAdVvnZNReFZw9CfWMnD6PmHaR6PiWpQy7YjCGpyvTbHqZzcVl";
        // URL endpoint để lấy danh sách các trang mà người dùng quản lý
        String managedPagesUrl = "https://graph.facebook.com/me/accounts?access_token=" + userAccessToken;

        // Tạo một đối tượng HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        try {
            // Gửi yêu cầu GET để lấy danh sách các trang mà người dùng quản lý
            HttpResponse response = httpClient.execute(new HttpGet(managedPagesUrl));

            // Kiểm tra mã trạng thái của phản hồi
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Đọc nội dung phản hồi
                String responseBody = EntityUtils.toString(response.getEntity());

                // Chuyển đổi nội dung phản hồi thành đối tượng JSON
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Lấy danh sách các trang mà người dùng quản lý
                JSONArray managedPages = jsonResponse.getJSONArray("data");

                // Duyệt qua danh sách các trang và like bài viết từ mỗi trang
                for (int i = 0; i < managedPages.length(); i++) {
                    JSONObject page = managedPages.getJSONObject(i);
                    String pageAccessToken = page.getString("access_token");
                    likePostWithPageAccessToken(postId, pageAccessToken);
                }
            } else {
                System.out.println("Lỗi khi lấy danh sách trang quản lý! Mã lỗi: " + statusCode);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void likePostWithPageAccessToken(String postId, String pageAccessToken) {
        // URL endpoint để like bài viết
        String likeUrl = "https://graph.facebook.com/" + postId + "/likes";

        // Tạo một yêu cầu POST đến URL để thực hiện like
        HttpPost httpPost = new HttpPost(likeUrl);
        httpPost.setHeader("Authorization", "Bearer " + pageAccessToken);

        HttpClient httpClient = HttpClients.createDefault();

        try {
            // Thực hiện yêu cầu và nhận phản hồi
            HttpResponse response = httpClient.execute(httpPost);

            // Kiểm tra mã trạng thái của phản hồi
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Nếu thành công, in ra thông báo
                System.out.println("Like bài viết thành công với access token của trang: " + pageAccessToken);
            } else {
                // Nếu không thành công, in ra mã lỗi
                System.out.println("Like bài viết không thành công với access token của trang: " + pageAccessToken + ". Mã lỗi: " + statusCode);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
