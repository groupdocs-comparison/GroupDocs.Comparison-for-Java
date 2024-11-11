* @package moltin/laravel-cart
* @author Chris Harvey <chris@molt.in>
* @copyright 2013 Moltin Ltd.
* @version dev
* @link http://github.com/moltin/laravel-cart
*
*/
namespace Moltin\Cart;
class CartServiceProvider extends ServiceProvider
{
    public function getStorageService()
    {
        $class = $this->app['config']->get('moltincart.storage', 'session');
        switch ($class) {
            case 'session':
                return new SessionStore;
            break;
            case 'cache':
                return new CacheStore;
            break;
            case 'file':
                return new FileStore;
            break;
            default:
                return $this->app->make($class);
            break;
        }
    }
    public function getIdentifierService()
    {
        $class = $this->app['config']->get('moltincart.identifier', 'cookie');
        switch ($class) {
            case 'requestcookie':
                return new CookieRequestIdentifier;
            break;
            case 'cookie':
                return new CookieIdentifier;
            break;
            default:
                return $this->app->make($class);
            break;
        }
    }
    public function register()
    {
        $that = $this;
        $this->app->singleton('cart', function() use ($that) {
            return new Cart($that->getStorageService(), $that->getIdentifierCustomer());
        });
        $this->app->alias('cart', 'Moltin\Cart\Cart');
    }
    /**
     * Bootstrap the application events.
     *
     * @return void
     */
    public function boot() {
        $this->publishes([
            __DIR__.'/../../config/moltincart.php' => config_path('cart.php'),
        ]);
    }
}