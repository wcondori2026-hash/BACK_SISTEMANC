package pe.com.ncquality.sad.util;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import pe.com.ncquality.sad.bean.Correo;

public class UtilCorreo {
	
	public static String envioToken(String token) throws Exception {
		final ClassTemplateLoader loader = new ClassTemplateLoader(UtilCorreo.class, "/templates");	
		Configuration cfg = new Configuration(new Version(2,3,30));
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		   
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("token", token);
        
		Template template = cfg.getTemplate("correoEnvioToken.ftl");
        Writer out = new StringWriter();
        template.process(model, out);
        //System.out.println("TEXTO >==>"+out.toString());
        return out.toString();
        
	}
	
	public static String envioNumeroSolcitud(String nomusu, String numSolicitud) throws Exception {
		final ClassTemplateLoader loader = new ClassTemplateLoader(UtilCorreo.class, "/templates");	
		Configuration cfg = new Configuration(new Version(2,3,30));
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		   
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nomusu", nomusu);
        model.put("numSolicitud", numSolicitud);
        
		Template template = cfg.getTemplate("correoRegistroSolicitud.ftl");
        Writer out = new StringWriter();
        template.process(model, out);
        //System.out.println("TEXTO >==>"+out.toString());
        return out.toString();
        
	}

	public static String envioParaVerificar(Correo correo) throws Exception {
		final ClassTemplateLoader loader = new ClassTemplateLoader(UtilCorreo.class, "/templates");
		Configuration cfg = new Configuration(new Version(2,3,30));
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("correo", correo);

		Template template = cfg.getTemplate("correoParaVerificar.ftl");
		Writer out = new StringWriter();
		template.process(model, out);
		//System.out.println("TEXTO >==>"+out.toString());
		return out.toString();

	}
	
	public static String envioNumeroExpediente(Correo correo) throws Exception {
		final ClassTemplateLoader loader = new ClassTemplateLoader(UtilCorreo.class, "/templates");	
		Configuration cfg = new Configuration(new Version(2,3,30));
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		   
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("correo", correo);
        
		Template template = cfg.getTemplate("correoRegistroExpediente.ftl");
        Writer out = new StringWriter();
        template.process(model, out);
        //System.out.println("TEXTO >==>"+out.toString());
        return out.toString();
        
	}
	
	public static String envioObservacion(Correo correo) throws Exception {
		final ClassTemplateLoader loader = new ClassTemplateLoader(UtilCorreo.class, "/templates");	
		Configuration cfg = new Configuration(new Version(2,3,30));
		cfg.setTemplateLoader(loader);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setLocale(Locale.US);
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		   
		Map<String, Object> model = new HashMap<String, Object>();
        model.put("correo", correo);
        
		Template template = cfg.getTemplate("correoRegistroObservacion.ftl");
        Writer out = new StringWriter();
        template.process(model, out);
        //System.out.println("TEXTO >==>"+out.toString());
        return out.toString();
        
	}
}
