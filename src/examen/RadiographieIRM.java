package examen;

import examen.types.RadiographieIRMPart;

public class RadiographieIRM extends ExamenElem{
    private RadiographieIRMPart type;

    public RadiographieIRM(RadiographieIRMPart type){
        super("RadiographieIRM",type);
    }
}
