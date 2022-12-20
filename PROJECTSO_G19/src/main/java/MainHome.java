import model.UserModel;
import service.UserService;
import java.util.List;

public class MainHome {
    public static void main(String[] args) {
        UserService userService = new UserService();
        List<UserModel> user = userService.getAllUser();
    }
}
