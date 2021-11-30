package chat.app.backend.models;

import lombok.Data;

import java.io.Serializable;
@Data
public class MyMessage implements Serializable {

    private static final long serialVersionUID = 59647513654L;
    private String text;
    private long date;
    private String username;
    private String types;
}
