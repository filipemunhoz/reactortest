package reactortest;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoTest {
	
	//@Test
	void firstMono() {
		
		Mono.just("A")
			.log()
			.subscribe();
	}

	//@Test
	void monoWithConsumer() {
		
		Mono.just("A")
			.log()
			.subscribe(System.out::println);
		
	}
	
	//@Test
	void monoWithDoOn() {
		
		Mono.just("A")
		.log()
		.doOnSubscribe(s -> System.out.println("Chamado no método doOnSubscribe " + s))
		.doOnRequest(s -> System.out.println("Chamado no método doOnRequest " + s))
		.doOnSuccess(s -> System.out.println("Chamado no método doOnSuccesst " + s))
		.subscribe();		
	}
	
	//@Test
	void monoWithEmpty() {
		
		Mono.empty()
			.log()
			.subscribe();
	}
	
	//@Test
	void emptyComplete() {
		
		Mono.empty()
			.log()
			.subscribe(System.out::println,
					null,
					() -> System.out.println("Fim"));
	}
	
	//@Test
	void errorExceptionMono() {
		Mono.error(new Exception())
			.log()
			.subscribe();
	}
	
	//@Test
	void errorConsumerMono() {
		
		Mono.error(new Exception())
			.log()
			.subscribe(System.out::println,
					e -> System.out.println("Error: " + e) 
					);
	}
	
	//@Test
	void errorOnErrorResumeMono() {
		
		Mono.error(new Exception())
			.onErrorResume(e -> {
				System.out.println("Caught: " + e);
				return Mono.just("New data");
			})
			.log()
			.subscribe();
	}
	
	@Test
	void onErrorReturnMono() {
		
		Mono.error(new Exception())
			.onErrorReturn("new data")
			.log()
			.subscribe();
		
	}
	
}
