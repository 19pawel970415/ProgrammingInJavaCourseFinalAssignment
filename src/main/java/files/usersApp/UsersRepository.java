package files.usersApp;

import lombok.Getter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UsersRepository {
    private List<User> users = new ArrayList<>();
    private final UserSerializerInterface serializer = new UserSerializer();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public String serializeUsers() {
        return serializer.serialize(users);
    }

    public void deserializeUsers(String data) {
        users = serializer.deserialize(data);
    }

    public void saveUsersToCSV(String fileName) {
        String data = serializeUsers();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }

    public void serializeUsersToBinaryFile(String fileName) {
        serializer.serializeToBinaryFile(users, fileName);
    }

    public void deserializeUsersFromBinaryFile(String fileName) {
        users = serializer.deserializeFromBinaryFile(fileName);
    }

    public void serializeUsersToJsonFile(String fileName) {
        serializer.serializeToJsonFile(users, fileName);
    }

    public void deserializeUsersFromJsonFile(String fileName) {
        users = serializer.deserializeFromJsonFile(fileName);
    }

    public void loadUsersFromFile(String fileName) {
        List<User> loadedUsers = serializer.deserializeFromJsonFile(fileName);
        if (loadedUsers != null) {
            users = loadedUsers;
            System.out.println("Users loaded from file: " + fileName);
        } else {
            System.out.println("Error loading users from file: " + fileName);
        }
    }
}
