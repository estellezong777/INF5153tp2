package examen;

import examen.types.RadiographieIRMPart;
import examen.types.RadiographieRayonXPart;

public class RadiographieIRM extends Examen{
    private RadiographieIRMPart type;

    public RadiographieIRM(RadiographieIRMPart type){
        this.type = type;
    }
}
