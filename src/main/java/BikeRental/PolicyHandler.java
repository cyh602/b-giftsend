package BikeRental;

import BikeRental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRentalCancelled_RentalCanceled(@Payload RentalCancelled rentalCancelled){

        if(rentalCancelled.isMe()){

            giftsendRepository.deleteById(rentalCancelled.getUserId());
            System.out.println("##### listener RentalCanceled : " + rentalCancelled.toJson());
        }

}
