package BikeRental;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="GiftsendList_table")
public class GiftsendList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String giftName;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getGiftName() {
            return giftName;
        }

        public void setGiftName(String giftName) {
            this.giftName = giftName;
        }

}
