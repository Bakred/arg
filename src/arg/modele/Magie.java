package arg.modele;

public class Magie {
    private String nomMagie;
    private String type;
    private int MPneed;
    private int minRange;
    private int maxRange;
    private String message;
    private String result;
    private String sndEffect;

    public String getNomMagie() {
        return nomMagie;
    }

    public void setNomMagie(String nomMagie) {
        this.nomMagie = nomMagie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMPneed() {
        return MPneed;
    }

    public void setMPneed(int mPneed) {
        MPneed = mPneed;
    }

    public int getMinRange() {
        return minRange;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSndEffect() {
        return sndEffect;
    }

    public void setSndEffect(String sndEffect) {
        this.sndEffect = sndEffect;
    }

}
