package reactortest;

import java.time.Duration;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {
	
	//@Test
	void firstFlux() {
		
		Flux.just("Rock", "Pop", "Country")
			.log()
			.subscribe();	
	}
	
	//@Test
	void fromIterable() {
		
		Flux.fromIterable(Arrays.asList("Rock", "Pop", "Country"))
		.log()
		.subscribe();			
	}
	
	//@Test
	void fromRange() {
		Flux.range(10, 5)
			.log()
			.subscribe();		
	}
	
	//@Test
	void fluxFromInterval() throws Exception {
		
		Flux.interval(Duration.ofSeconds(1))
			.log()
			.take(2)
			.subscribe();
			
		Thread.sleep(5000);
	}
	
	@Test
	void fluxRequest() {
		Flux.range(1, 5)
			.log()
			.subscribe(null,
						null,
						null,
						s -> s.request(3));
	}

}
