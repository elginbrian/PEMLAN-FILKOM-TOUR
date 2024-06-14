package controller;

import model.UserModel;
import util.StringToArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AuthController extends AppController {

    public static String PostUser(UserModel user) {
        try(BufferedWriter bfWriter = new BufferedWriter(new FileWriter(authRoute, true))){
            if(user.getUsername().equals("") || user.getPassword().equals("")){
                return "Lengkapi semua data!";
            }

            if(user.getPassword().length() < 6){
                return "Password minimal 6 karakter";
            }
            bfWriter.write(user.getStringArray());
            bfWriter.newLine();
            return "Insert data success";
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public static String LoginUser(String username, String password){
        try {
            if(username.equals("") || password.equals("")){
                return "Lengkapi semua data!";
            }

            if(password.length() < 6){
                return "Password minimal 6 karakter";
            }

            BufferedReader bfReader = new BufferedReader(new FileReader(authRoute));
            String line;
            String result = "Username atau Password Salah";

            while((line = bfReader.readLine()) != null){
                String[] arr = StringToArray.convert(line);
                UserModel user = new UserModel(arr[0], arr[1], arr[2], arr[3]);
                if(user.getUsername().replace(" ","").equals(username) && user.getPassword().replace(" ","").equals(password)){
                    result = line;
                }
            }

            System.out.println(result);
            return result;
        } catch (Exception e){
            return e.getLocalizedMessage();
        }
    }

    public static List<String> GetUsers(List<String> list){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(authRoute));
            String line;

            while((line = bfReader.readLine()) != null){
                list.add(line);
            }

            return list;
        } catch (Exception e){
            return list;
        }
    }

    public static String GetUserByID(String id){
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(authRoute));
            String line;
            String result = "";

            while((line = bfReader.readLine()) != null){
                if(line.contains(id)){
                    result = line;
                }
            }

            return result;
        } catch (Exception e){
            return "";
        }
    }
}