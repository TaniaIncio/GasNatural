
package com.gmd.gasnatural.data.services.request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class EmpresaInstaladoraSeleccionadaInRO {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("appInvoker")
    @Expose
    private String appInvoker;
    @SerializedName("idEmpresaInstaladora")
    @Expose
    private Integer idEmpresaInstaladora;

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The appInvoker
     */
    public String getAppInvoker() {
        return appInvoker;
    }

    /**
     *
     * @param appInvoker
     * The appInvoker
     */
    public void setAppInvoker(String appInvoker) {
        this.appInvoker = appInvoker;
    }

    /**
     *
     * @return
     * The idEmpresaInstaladora
     */
    public Integer getIdEmpresaInstaladora() {
        return idEmpresaInstaladora;
    }

    /**
     *
     * @param idEmpresaInstaladora
     * The idEmpresaInstaladora
     */
    public void setIdEmpresaInstaladora(Integer idEmpresaInstaladora) {
        this.idEmpresaInstaladora = idEmpresaInstaladora;
    }

    public JSONObject toJSON()  {
        JSONObject object=null;
        try{
            object = new JSONObject();
            JSONObject items = new JSONObject();
            items.put("token",getToken());
            items.put("appInvoker",getAppInvoker());
            items.put("idEmpresaInstaladora",getIdEmpresaInstaladora());

            object.put("empresaInstaladora",items);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return object;
    }

}
