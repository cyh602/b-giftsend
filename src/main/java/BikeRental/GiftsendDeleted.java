package BikeRental;

public class GiftsendDeleted extends AbstractEvent {

    private Long id;

    public GiftsendDeleted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
