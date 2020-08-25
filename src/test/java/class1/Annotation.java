package class1;

import lombok.Data;
import lombok.NonNull;

@Data
class Annotation {
    @NonNull
    private  String name;
    @NonNull
    private String phone;
    @NonNull
    private String city;
    @NonNull
    private String date;

}
