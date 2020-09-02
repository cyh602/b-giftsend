package BikeRental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Giftsend_table")
public class Giftsend {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String giftName;

    @PostPersist
    public void onPostPersist(){
        GiftsendCreated giftsendCreated = new GiftsendCreated();
        BeanUtils.copyProperties(this, giftsendCreated);
        giftsendCreated.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        GiftsendUpdated giftsendUpdated = new GiftsendUpdated();
        BeanUtils.copyProperties(this, giftsendUpdated);
        giftsendUpdated.publishAfterCommit();


    }

    @PreRemove
    public void onPreRemove(){
        GiftsendDeleted giftsendDeleted = new GiftsendDeleted();
        BeanUtils.copyProperties(this, giftsendDeleted);
        giftsendDeleted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }




}
