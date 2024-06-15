package files;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String emailAddress;
    private int age;
}
