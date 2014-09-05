package domain;


import com.uqbar.commons.collections.Transformer;

public class FinalAprobadoTransformer implements Transformer<Evaluacion, String>{
	@Override
	public String transform(Evaluacion evaluacion) {
		return evaluacion.getAprobado()? "Sí" : "No";
	}
}