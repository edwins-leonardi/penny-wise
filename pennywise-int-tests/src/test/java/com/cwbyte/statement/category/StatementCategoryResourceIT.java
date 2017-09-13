package com.cwbyte.statement.category;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URL;

import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cwbyte.it.setup.JsonTestUtils;
import com.cwbyte.it.setup.ResourceClient;
import com.cwbyte.model.statement.StatementCategory;
import com.google.gson.Gson;

import dumb.Greeter;
import dumb.PhraseBuilder;

@RunWith(Arquillian.class)
public class StatementCategoryResourceIT {

	@ArquillianResource
	private URL url;

	private ResourceClient resourceClient;

	private static final String PATH_RESOURCE = "categories";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class).addPackages(true, "com.cwbyte")
				.addClasses(Greeter.class, PhraseBuilder.class)
				.addAsResource("persistence-integration.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				//
				// .addAsResource("META-INF/services/javax.enterprise.inject.spi.Extension")
				// .addAsWebInfResource("jboss-web.xml")
				// .addAsResource("application.properties")
				.setWebXML(new File("src/test/resources/web.xml"));
		// .addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml")
		// .resolve("com.google.code.gson:gson",
		// "org.mockito:mockito-core").withTransitivity().asFile());
		// return ShrinkWrap.create(JavaArchive.class).addClasses(Greeter.class,
		// PhraseBuilder.class)
		// .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		// return ArquillianTestUtils.createDeploymentArchive();
	}

	@Before
	public void setup() {
		this.resourceClient = new ResourceClient(url);
	}

	@Test
	@RunAsClient
	public void addValidCategoryAndFindIt() {
		StatementCategory sc = StatementCategory.builder().name("alimentacao").build();
		// JsonObject obj = new JsonObject();
		// obj.addProperty("name", sc.getName());
		Response response = resourceClient.resourcePath(PATH_RESOURCE).postWithContent(new Gson().toJson(sc));
		assertThat(response.getStatus(), is(equalTo(Response.ok())));
		Long id = JsonTestUtils.getIdFromJson(response.readEntity(String.class));

	}

}
