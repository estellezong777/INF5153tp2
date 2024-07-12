package examen;

import examen.types.RadiographieRayonXPart;

public class RadiographieRayonX extends Examen{
    private RadiographieRayonXPart type;

    public RadiographieRayonX(RadiographieRayonXPart type) {
            this.type = type;
            }


    public void setType(RadiographieRayonXPart type) {
            this.type = type;
            }


    public RadiographieRayonXPart getType() {
            return this.type;
            }
}
