package com.gmd.gasnatural.presentation.util;

/**
 * Created by tincio on 14/12/2015.
 */
public class Constants {
    public static int TIMEOUT = 10000;

    public static class NombreTablas {
        public static String TABLA_ESTABLECIMIENTOS = "TB_ESTABLECIMIENTOS";
        public static String TABLA_FAVORITOS_LUGARES = "TB_FAVORITOS_LUGARES";
        public static String TABLA_NOTIFICACIONES = "TB_NOTIFICACIONES";
    }

    public static class Servicios{

        public static String URL_BASE_LOCAL= "http://10.241.162.121:8080/facilito_rest_old/remote/";//en esta ruta no hay data
        public static String URL_BASE_PRUEBA = "http://www.perusynclatam.com/facilito_rest_old/remote/";
        public static String URL_BASE_USADA=URL_BASE_PRUEBA;

        public static String POST_VERIFICAR_RED = URL_BASE_USADA + "gasnatural/consultarRedGas";
        public static String POST_LISTAR_EMPRESAS_INSTALADORAS = URL_BASE_USADA + "gasnatural/listarEmpresaInstaladora";
        public static String POST_OBTENER_EMPRESA_INSTALADORA = URL_BASE_USADA + "gasnatural/listarEmpresaInstaladora";

    }

    public static class Error {
        public static String fail = "Se produjo un error con la conexión";
        public static String parseError = "Se produjo un error con la información";
        public static String serverError = "Estamos teniendo problemas al conectar con el servidor. Por favor reintente";
        public static String internetConnectionFail = "Conexión no disponible. Se requiere una conexión a Internet para utilizar esta App";
        public static String timeOutError = "Lo sentimos, estamos teniendo problemas con su conexión";
        public static String dataBaseError = "Se produjo un error en la base de datos";
        public static String dataVacia = "Error, no se encontraron datos";
    }


    public static class Values{
        public static int numFinger = 3;
        public static float ZOOM_MAPA_DEFAULT = 14;
        public static float ZOOM_MAPA3D_DEFAULT = 14;
    }


    public static class Preferencias{
        public static String SENT_TOKEN_TO_SERVER = "SENT_TOKEN_TO_SERVER";
        public static String REGISTRATION_COMPLETE = "REGISTRATION_COMPLETE";
        public static String MIS_PREFERENCIAS = "MisPreferencias";

    }
}
