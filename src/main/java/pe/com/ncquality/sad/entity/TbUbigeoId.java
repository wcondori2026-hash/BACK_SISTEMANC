/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.ncquality.sad.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TbUbigeoId {
    String vIdDep;
    String vIdPro;
    String vIdDis;

    public TbUbigeoId() {
    }

    public TbUbigeoId(String vIdDep, String vIdPro, String vIdDis) {
        this.vIdDep = vIdDep;
        this.vIdPro = vIdPro;
        this.vIdDis = vIdDis;
    }

    
    @Column(name = "id_dep", nullable = false, length = 2)
    public String getvIdDep() {
        return vIdDep;
    }

    public void setvIdDep(String vIdDep) {
        this.vIdDep = vIdDep;
    }

    
    @Column(name = "id_pro", nullable = false, length = 2)
    public String getvIdPro() {
        return vIdPro;
    }

    public void setvIdPro(String vIdPro) {
        this.vIdPro = vIdPro;
    }

    @Column(name = "id_dis", nullable = false, length = 4)
    public String getvIdDis() {
        return vIdDis;
    }

    public void setvIdDis(String vIdDis) {
        this.vIdDis = vIdDis;
    }
    
    public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbUbigeoId))
			return false;
		TbUbigeoId castOther = (TbUbigeoId) other;

		return ((this.getvIdDep() == castOther.getvIdDep()) || (this.getvIdDep() != null && castOther.getvIdDep() != null
				&& this.getvIdDep().equals(castOther.getvIdDep())))
				&& ((this.getvIdPro() == castOther.getvIdPro() || (this.getvIdPro() != null
						&& castOther.getvIdPro() != null && this.getvIdPro().equals(castOther.getvIdPro()))))
				&& ((this.getvIdDis() == castOther.getvIdDis() || (this.getvIdDis() != null
						&& castOther.getvIdDis() != null && this.getvIdDis().equals(castOther.getvIdDis()))));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getvIdDep() == null ? 0 : this.getvIdDep().hashCode());
		result = 37 * result + (getvIdDis() == null ? 0 : this.getvIdDis().hashCode());
		result = 37 * result + (getvIdPro() == null ? 0 : this.getvIdPro().hashCode());
		return result;
	}
}
