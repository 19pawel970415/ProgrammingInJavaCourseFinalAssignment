package files.usersApp;

import java.util.List;

public interface UserSerializerInterface {
    String serialize(List<User> users);
    List<User> deserialize(String data);
    void serializeToBinaryFile(List<User> users, String fileName);
    List<User> deserializeFromBinaryFile(String fileName);
    void serializeToJsonFile(List<User> users, String fileName);
    List<User> deserializeFromJsonFile(String fileName);
}
