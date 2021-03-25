import java.util.ArrayList;

public class IdentityService extends AbstractService {

    private ArrayList<String> identityList = new ArrayList<String>();

    public IdentityService(String nama) {
        super(nama);
    }

    public ArrayList<String> getIdentity() {
        return this.identityList;
    }

    public void addIdentity(String identity){
        if (this.getServiceState() == STATE.RUNNING){
            this.identityList.add(identity);
        }
    }

    public void removeIdentity(String identity){
        if (this.getServiceState() == STATE.RUNNING){
            this.identityList.remove(identity);
        }
    }

    @Override
    public void init() {
        this.setServiceState(STATE.INIT);
    }

    @Override
    public void start() {
        this.setServiceState(STATE.RUNNING);
    }

    @Override
    public void stop() {
        this.setServiceState(STATE.DIE);
    }

    public Boolean isIdentityExist(String identity){
        if (this.getServiceState() == STATE.RUNNING){
            return Boolean.valueOf(this.identityList.stream().filter(e -> e.equals(identity)).findAny().isPresent());
        } else {
            return null;
        }
    }
    
}