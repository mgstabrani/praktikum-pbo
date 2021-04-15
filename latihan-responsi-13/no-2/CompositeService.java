import java.util.stream.Collectors;
import java.util.ArrayList;

public class CompositeService extends AbstractService{

    private ArrayList<AbstractService> serviceList = new ArrayList<AbstractService>();

    public CompositeService(String nama) {
        super(nama);
    }

    public ArrayList<AbstractService> getServices(){
        return this.serviceList;
    }

    public void addService(AbstractService service){
        if (this.getServiceState() != STATE.DIE){
            this.serviceList.add(service);
        }
    }

    public void removeService(AbstractService service){
        if (this.getServiceState() != STATE.DIE){
            this.serviceList.remove(service);
        }
    }

    @Override
    public void init() {
        this.serviceList.forEach(service -> service.init());
        this.setServiceState(STATE.INIT);
    }

    @Override
    public void start() {
        this.serviceList.forEach(service -> service.start());
        this.setServiceState(STATE.RUNNING);
    }

    @Override
    public void stop() {
        this.setServiceState(STATE.DIE);
        int running = this.serviceList.stream().filter(service -> service.getServiceState() == STATE.RUNNING).collect(Collectors.toList()).size();
        this.serviceList.forEach(service -> service.stop());
        System.out.println("RUNNING service total : " + running);
    }
    
}