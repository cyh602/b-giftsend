package BikeRental;

import BikeRental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GiftsendListViewHandler {


    @Autowired
    private GiftsendListRepository giftsendListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenGiftsendCreated_then_CREATE_1 (@Payload GiftsendCreated giftsendCreated) {
        try {
            if (giftsendCreated.isMe()) {
                // view 객체 생성
                GiftsendList giftsendList = new GiftsendList();
                // view 객체에 이벤트의 Value 를 set 함
                giftsendList.setId(giftsendCreated.getUserId());
                giftsendList.setGiftName(giftsendCreated.getGiftName());
                // view 레파지 토리에 save
                giftsendListRepository.save(giftsendList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}