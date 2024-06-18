package files.usersApp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSerializer implements UserSerializerInterface {
    private final Gson gson = new Gson();

    @Override
    public String serialize(List<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getName()).append(";");
            sb.append(user.getSurname()).append(";");
            sb.append(user.getAge()).append(";");
            sb.append(user.getEmailAddress()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<User> deserialize(String data) {
        List<User> users = new ArrayList<>();
        String[] usersArray = data.split("\n");
        for (String userData : usersArray) {
            if (!userData.trim().isEmpty()) {
                String[] userFields = userData.split(";");
                User user = new User();
                user.setName(userFields[0]);
                user.setSurname(userFields[1]);
                user.setAge(Integer.parseInt(userFields[2]));
                user.setEmailAddress(userFields[3]);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public void serializeToBinaryFile(List<User> users, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Error serializing to binary file: " + e.getMessage());
        }
    }

    @Override
    public List<User> deserializeFromBinaryFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing from binary file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void serializeToJsonFile(List<User> users, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.err.println("Error serializing to JSON file: " + e.getMessage());
        }
    }

    @Override
    public List<User> deserializeFromJsonFile(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (IOException e) {
            System.err.println("Error deserializing from JSON file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
