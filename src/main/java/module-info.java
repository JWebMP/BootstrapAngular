import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.bootstrap.angular.BootstrapAngularPageConfigurator;

module com.jwebmp.plugins.bootstrap.angular {

    requires com.jwebmp.angular.forms;
    requires com.jwebmp.plugins.bootstrap;
    requires com.jwebmp.client;

    provides IPageConfigurator with BootstrapAngularPageConfigurator;
}