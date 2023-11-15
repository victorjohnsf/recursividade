package aulaas;
import java.util.Stack;
import java.time.Duration;


public class torre {
	static Long movimento = (long) 0;
	public static void main(String[] args) {
		Long i;
		
		Stack<Long> original = new Stack<>();
		Stack<Long> dest = new Stack<>();
		Stack<Long> aux = new Stack<>();
		
		for(i=(long) 1; i<=40; i++){
			
			original.push(i);
		}
		long startTime = System.currentTimeMillis();
		
		torreDeHanoi(original.size(), original, dest, aux );
		
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		String tempoFormatado = converterParaFormatoHHMMSSmm(elapsedTime);
		
		System.out.println("Tempo de execução: " + tempoFormatado);
		System.out.println("Movimentos: " + movimento);
	}
	
	public static void torreDeHanoi(int i, Stack<Long> original, Stack<Long> dest, Stack<Long> aux ) {
		
		if (i > 0) {
			torreDeHanoi(i-1, original, aux, dest);
				dest.push(original.pop());
				movimento ++;
				torreDeHanoi(i-1, aux, dest, original);
		}
	  }
	
	 public static String converterParaFormatoHHMMSSmm(long elapsedTime) {
	        Duration duration = Duration.ofMillis(elapsedTime);
	        long horas = duration.toHours();
	        long minutos = duration.toMinutes() % 60;
	        long segundos = duration.getSeconds() % 60;
	        long milissegundos = elapsedTime % 1000;

	        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);
	    }
	}