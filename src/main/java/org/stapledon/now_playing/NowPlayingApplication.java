package org.stapledon.now_playing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stapledon.now_playing.components.HistoryComponent;
import org.stapledon.now_playing.components.ProductsComponent;
import org.stapledon.now_playing.components.SuperpacksComponent;

@SpringBootApplication
public class NowPlayingApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(NowPlayingApplication.class, args);
		var history = ctx.getBean("historyComponent", HistoryComponent.class);
		history.tables();
		history.recognitionHistory();

		var product = ctx.getBean("productsComponent", ProductsComponent.class);
		product.tables();

		var superpacks = ctx.getBean("superpacksComponent", SuperpacksComponent.class);
		superpacks.tables();
	}
}
