package examen;

import examen.types.RadiographieIRMPart;
import examen.types.RadiographieRayonXPart;

public class RadiographieIRM extends ExamenElem{
    private RadiographieIRMPart type;

    public RadiographieIRM(RadiographieIRMPart type){
        super("RadiographieIRM",type);
    }
}
