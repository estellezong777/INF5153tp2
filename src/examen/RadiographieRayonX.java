package examen;

import examen.types.RadiographieRayonXPart;

public class RadiographieRayonX extends ExamenElem{
    private RadiographieRayonXPart type;

    public RadiographieRayonX(RadiographieRayonXPart type) {

            super("RadiographieRayonX",type);
    }


    public void setType(RadiographieRayonXPart type) {
            this.type = type;
            }


    public RadiographieRayonXPart getType() {
            return this.type;
            }
}
