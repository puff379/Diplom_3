package CommonMethods;
import java.util.concurrent.ThreadLocalRandom;

public class Variables {

    public String name;
    public  String email;
    //валидный пароль для регистрации/авторизации
    public  String password ="123456";
    //невалидный пароль для регистрации
    public String incorrectPassword = "1234";
    //логин сушествующего пользователя для авторизации
    public String existingUser = "vasya@maill.ru";

    //метод генерации пользователей
    public Variables() {
        int value = ThreadLocalRandom.current().nextInt(987654, 1111111111 + 1);
        //генерация имени
        this.name = String.valueOf(value);
        //генерация email
        this.email = value + "@pocta.ru";
    }
}
