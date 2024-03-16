package CodeDao;

import java.io.IOException;

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

public class FacebookAPIClientLike {
	static String userAccessToken = "EAABwzLixnjYBOZCjZC0AgxaNAFvUXvMXqxMG3e5yBsK2dtwOzlZCCXIOE21JNt7CVVHuTuZCnia5PsxfWd2ZBauLsMYh51lfZBr2bPo0LiAB5ZBXbahZA1hfHZBpbCGkH4sR1YChK9cyJUNHSAel2pGxD5NclTSy7QZCA7VIb6VTHkYYFZArOZA1ZAYHbkJWpa6ZAfr0cQhZAOaZBmlgw70ZC";
    public static void main(String[] args) {
        // Access token của người dùng
     
        
        // URL endpoint để lấy danh sách các trang vị trí mà người dùng quản lý
        String managedPlacesUrl = "https://graph.facebook.com/me/places?access_token=" + userAccessToken;

        // Tạo một đối tượng HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        try {
            // Gửi yêu cầu GET để lấy danh sách các trang vị trí mà người dùng quản lý
            HttpResponse response = httpClient.execute(new HttpGet(managedPlacesUrl));

            // Kiểm tra mã trạng thái của phản hồi
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Đọc nội dung phản hồi
                String responseBody = EntityUtils.toString(response.getEntity());

                // Chuyển đổi nội dung phản hồi thành đối tượng JSON
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Lấy danh sách các trang vị trí mà người dùng quản lý
                JSONArray managedPlaces = jsonResponse.getJSONArray("data");

                // Duyệt qua danh sách các trang vị trí và tạo page mới cho mỗi trang vị trí
                for (int i = 0; i < managedPlaces.length(); i++) {
                    JSONObject place = managedPlaces.getJSONObject(i);
                    // Lấy thông tin vị trí của trang vị trí
                    String placeName = place.getString("name");
                    String placeLocation = place.getJSONObject("location").getString("city"); // Ví dụ: lấy thành phố
                    // Gọi hàm để tạo page mới với thông tin vị trí
                    createPageWithLocation(placeName, placeLocation);
                }
            } else {
                System.out.println("Lỗi khi lấy danh sách trang vị trí quản lý! Mã lỗi: " + statusCode);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createPageWithLocation(String placeName, String placeLocation) {
        // Địa chỉ URL endpoint để tạo page
        String pageCreationUrl = "https://graph.facebook.com/me/accounts";

        // Các thông tin khác cần thiết để tạo page mới (tùy thuộc vào yêu cầu của Facebook API)
        String pageCategory = "Local Business"; // Loại trang
        String pageDescription = "This is a page for " + placeName + " in " + placeLocation; // Mô tả trang
        
        // Tạo JSON object chứa thông tin cần thiết để tạo page mới
        JSONObject pageData = new JSONObject();
        pageData.put("name", placeName);
        pageData.put("category", pageCategory);
        pageData.put("about", pageDescription);

        // Tạo yêu cầu POST để tạo page
        HttpPost httpPost = new HttpPost(pageCreationUrl);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + userAccessToken);

        try {
            // Đặt nội dung của yêu cầu POST là thông tin JSON của page
            StringEntity entity = new StringEntity(pageData.toString());
            httpPost.setEntity(entity);

            // Thực hiện yêu cầu POST và nhận phản hồi
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpPost);

            // Kiểm tra mã trạng thái của phản hồi
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Nếu thành công, in ra thông báo
                System.out.println("Page mới đã được tạo cho " + placeName + " tại " + placeLocation);
            } else {
                // Nếu không thành công, in ra mã lỗi
                System.out.println("Lỗi khi tạo page mới cho " + placeName + " tại " + placeLocation + ". Mã lỗi: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
