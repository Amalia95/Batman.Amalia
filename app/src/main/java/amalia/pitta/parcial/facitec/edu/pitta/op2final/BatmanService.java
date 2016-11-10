package amalia.pitta.parcial.facitec.edu.pitta.op2final;



import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by carmen on 07/11/2016.
 */
public interface BatmanService {
    @GET("/?s=batman")

    void obtenerBatman(Callback<Result> callback);
}