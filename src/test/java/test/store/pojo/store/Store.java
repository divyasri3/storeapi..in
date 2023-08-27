package test.store.pojo.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/*{
        "id": 0,
        "petId": 0,
        "quantity": 0,
        "shipDate": "2023-08-13T11:28:11.472Z",
        "status": "placed",
        "complete": true

        }*/

@Setter
@Getter
public class Store
{

@JsonProperty("id")
    private int id;
    @JsonProperty("petId")
    private int petId;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("shipDate")
    private String shipDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("complete")
    private boolean complete;


}
