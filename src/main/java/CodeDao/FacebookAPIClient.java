package CodeDao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;




public class FacebookAPIClient {
    public static void main(String[] args) {
        // Access token của bạn
        String accessToken = "EAABwzLixnjYBO803X9okmF1pyW7tVAEkKZAuA4VRftB9PJh6OuDocjOdnQ43XsPxS2wHUiJA3ji6xS4BRd0zH4bYxr85zJdyUrn1wHWUY55SwU5siIhErSHO59e3Sud8EvsvXZADtsZC6IJxYhZActykpUuqMdxWV8NgtzTP782ZB3qtuflGOQVwJRun7P8n09nLb2UDWGxbV";

        // ID của bài viết bạn muốn like
        String postId = "1127554728668386";

        // URL endpoint để like bài viết
        String likeUrl = "https://graph.facebook.com/" + postId + "/likes";

        // Tạo một đối tượng HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        // Tạo một yêu cầu POST đến URL để thực hiện like
        HttpPost httpPost = new HttpPost(likeUrl);
        httpPost.setHeader("Authorization", "Bearer " + accessToken);

        try {
            // Thực hiện yêu cầu và nhận phản hồi
            HttpResponse response = httpClient.execute(httpPost);

            // Kiểm tra mã trạng thái của phản hồi
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Nếu thành công, in ra thông báo
                System.out.println("Like bài viết thành công!");
            } else {
                // Nếu không thành công, in ra mã lỗi
                System.out.println("Like bài viết không thành công! Mã lỗi: " + statusCode);
            }

            // Đọc nội dung phản hồi
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Nội dung phản hồi: " + responseBody);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
