package BikeRental;

public class GiftsendUpdated extends AbstractEvent {

    private Long id;

    public GiftsendUpdated(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
