# 
# Example of config.ru for Application based on Sinatra + WeBrick + SSL
#
require File.dirname(__FILE__) + '/environment'
require File.dirname(__FILE__) + '/your_sinatra_app'
require 'webrick'
require 'webrick/https'

certificate = "/your/path/certs/myssl.crt"
private_key = "/your/path/certs/myssl.key"

ssl_options = {
  :Port             => 443,
  :SSLEnable        => true,
  :SSLVerifyClient  => OpenSSL::SSL::VERIFY_NONE,
  :SSLCertificate   => OpenSSL::X509::Certificate.new(File.open(certificate).read),
  :SSLPrivateKey    => OpenSSL::PKey::RSA.new(File.open(private_key).read),
  :SSLCertName      => [ [ "CN", WEBrick::Utils::getservername ] ]
}

server = WEBrick::HTTPServer.new(options)
server.mount "/", Rack::Handler::WEBrick, YourSinatraApp.new
Signal.trap(:INT) { server.shutdown }
server.start