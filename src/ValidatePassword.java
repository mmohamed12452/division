public class ValidatePassword {
static int score = 0;
    public static int validatePassword(String password)
    {
        //  at least 8 characters
      if(password.length() >= 8){
          score++;
      }
      // at least one uppercase letter
      if(password.matches(".*[A-Z].*")){
          score++;
      }
      // at least one lowercase letter
      if(password.matches(".*[a-z].*")){
          score++;
      }
      // at least one digit
      if(password.matches(".*[0-9].*")){
          score++;
      }
      if(password.matches(".*[!@#$%^&*].*"))
      {
          score++;
      }
      return score;
    }
    public static void main(String[] args) {
     String[] testPassword = {
             "Pass123!",
             "password",
             "PASSWORD123",
             "12345678",
             "Weak",
             "Str0ng!Pass",
             "Short1!"
     };
     for(String pwd : testPassword) {
         int strength = validatePassword(pwd);
         System.out.println("Password: " + pwd + " | Strength: " + strength + "/5");
     }
    }
}
