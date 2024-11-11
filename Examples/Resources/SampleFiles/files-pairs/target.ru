# 
# Example of config.ru for Application based on Sinatra + WeBrick + SSL
#
require File.dirname(__FILE__) + '/environment'
require File.dirname(__FILE__) + '/your_sinatra_add'
require 'webrick'
require 'webrick/https'

certificate = "/your/path/certs/myssl.crt"
private_key = "/your/path/certs/myssl.key"

server = WEBrick::HTTPServer.new(options)
server.mount "/", Rack::Handler::WEBrick, YourSinatraApp.new
Signal.trap(:INT) { server.shutdown }
server.start