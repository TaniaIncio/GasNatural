
package com.gmd.gasnatural.data.services.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmpresasInstaladorasOutRO {

    @SerializedName("resultCode")
    @Expose
    private Integer resultCode;
    @SerializedName("empresasInstaladoras")
    @Expose
    private List<EmpresaInstaladora> empresasInstaladoras = new ArrayList<EmpresaInstaladora>();

    /**
     * 
     * @return
     *     The resultCode
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * 
     * @param resultCode
     *     The resultCode
     */
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 
     * @return
     *     The empresasInstaladoras
     */
    public List<EmpresaInstaladora> getEmpresasInstaladoras() {
        return empresasInstaladoras;
    }

    /**
     * 
     * @param empresasInstaladoras
     *     The empresasInstaladoras
     */
    public void setEmpresasInstaladoras(List<EmpresaInstaladora> empresasInstaladoras) {
        this.empresasInstaladoras = empresasInstaladoras;
    }

}
