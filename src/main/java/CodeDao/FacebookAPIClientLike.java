package CodeDao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class FacebookAPIClientLike {
    public static void main(String[] args) {
        // Access token của bạn
        String accessToken = "EAABwzLixnjYBO803X9okmF1pyW7tVAEkKZAuA4VRftB9PJh6OuDocjOdnQ43XsPxS2wHUiJA3ji6xS4BRd0zH4bYxr85zJdyUrn1wHWUY55SwU5siIhErSHO59e3Sud8EvsvXZADtsZC6IJxYhZActykpUuqMdxWV8NgtzTP782ZB3qtuflGOQVwJRun7P8n09nLb2UDWGxbV";

        // Tạo ra 3 page
        for (int i = 0; i < 3; i++) {
            createPage(accessToken, "Haicon gà" + (i + 1), "1006597106868677", "Community",
                    "https://scontent.fsgn2-10.fna.fbcdn.net/v/t39.30808-6/428610501_1127554695335056_8417082669027061313_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_ohc=RtUm2tnSpkYAX8eRAQY&_nc_ht=scontent.fsgn2-10.fna&oh=00_AfA6lKj9XodfWKtmBJK_tWDdJGfegMa1dIJIJ21ieDQuXg&oe=65EE29D6",
                    "https://example.com", "0349748529", "Đà Nẵng");
        }
    }

    public static void createPage(String accessToken, String name, String category, String about, String picture,
            String website, String phone, String location) {
        // URL endpoint để tạo page
        String pageCreationUrl = "https://graph.facebook.com/me/accounts";

        // Dữ liệu JSON để tạo page
        JSONObject pageData = new JSONObject();
        pageData.put("name", name);
        pageData.put("category", category);
        pageData.put("about", about);
        pageData.put("picture", picture);
        pageData.put("website", website);
        pageData.put("phone", phone);
        pageData.put("location", location);
        pageData.put("access_token", accessToken);

        // Tạo một đối tượng HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        // Tạo một yêu cầu POST để tạo page
        HttpPost httpPost = new HttpPost(pageCreationUrl);
        httpPost.setEntity(new StringEntity(pageData.toString(), "UTF-8"));
        httpPost.setHeader("Content-Type", "application/json");

        try {
            // Thực hiện yêu cầu và nhận phản hồi
            HttpResponse response = httpClient.execute(httpPost);

            // Kiểm tra mã trạng thái của phản hồi khi tạo page
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.println("Page đã được tạo thành công!");
            } else {
                System.out.println("Tạo page không thành công! Mã lỗi: " + statusCode);
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
