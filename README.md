# metricsWithActuator

Technologies

Javav 17
Spring boot
Webflux
Actuator

Link to actuator http://localhost:8082/actuator

It is been made some custom mtrics configurations, below I describe



Created two metrics with @timed notation

*  In a service: ProductoService this is executed with this endpoint localhost:8082/product

*  In a controller: ExecutionsController this is executed with this endpoint localhost:8082/sleep?ms=1000

Created one metric with MeterRegistry injection

*  In a service: SleepService executed with this endpoint localhost:8082/sleep?ms=1000

Created a custom Health mtric

*  In a service: ConsumeServiceDummy, that it's executed automatically




