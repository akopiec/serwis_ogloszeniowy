package app;

import app.entity.Motorization;

public class AdditionalClass {

    private Motorization motorizationFirst;

    private Motorization motorizationSecond;

    public Motorization getMotorizationFirst(){

        return motorizationFirst;
    }
    public Motorization getMotorizationSecond(){

        return motorizationSecond;
    }
    public void setMotorizationFirst(Motorization motorizationFirst){

        this.motorizationFirst=motorizationFirst;
    }
    public void setMotorizationSecond(Motorization motorizationSecond){

        this.motorizationSecond=motorizationSecond;
    }
}