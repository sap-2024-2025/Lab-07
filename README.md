#### Software Architecture and Platforms - a.y. 2024-2025

## Lab #07-20241115 

Back to Deployability Patterns (module-2.5)
- [Deploying Microservices using Docker](https://docs.google.com/document/d/1f31xacpq7LNfKfoR77aNZnamDTNwVRGUpVf8t8hA3ew/edit?usp=sharing) -- Exploiting Docker Compose
    - cooperative pixel art example in ``docker-compose.yml``

Observability Patterns (module-2.6): A Look at some tools and technologies
- **Health check API**
    - Instrumenting microservices with with an Health check API
        - exposing a REST /health endpoint, to get the health check status
        - Status format example: [MicroProfile Health](https://github.com/eclipse/microprofile-health)
    - Who performs the health check?
		- exploting [Docker HEALTHCHECK](https://docs.docker.com/reference/dockerfile/#healthcheck)
		- [healthcheck](https://docs.docker.com/reference/compose-file/services/#healthcheck) attribute in Docker Compose file
			- cooperative pixel art example - ``docker-compose.yml``
- **Application metrics**
    - Instrumenting microservices with a metrics exporter 
    - Accessing data collected on the metrics service
    - [Prometheus platform](https://prometheus.io)
        - [concepts](https://prometheus.io/docs/introduction/overview/)
            - [architecture](https://prometheus.io/docs/introduction/overview/#architecture)
            - [data model](https://prometheus.io/docs/concepts/data_model/#data-model)
            - [metric and label naming](https://prometheus.io/docs/practices/naming/)
            - [getting started](https://prometheus.io/docs/prometheus/latest/getting_started/)
        - metrics service side
            - [installation](https://prometheus.io/docs/prometheus/latest/installation/) 
            - [configuration](https://prometheus.io/docs/prometheus/latest/configuration/configuration/)
            - [querying](https://prometheus.io/docs/prometheus/latest/querying/basics/)  
        - instrumentation side
            - [instrumentation](https://prometheus.io/docs/instrumenting/clientlibs/)
            - [Java client library](https://github.com/prometheus/client_java)
            - [Quickstart](https://prometheus.github.io/client_java/getting-started/quickstart/)
        - Example: ``test-obs``
			- using Docker Compose to run Prometheus and a simple instrumented Java-based application
				- simple dockerised Java application instrumented to expose some metrics (accessible at http://localhost:9400/metrics)
				- Prometehus accessible at http://localhost:9090
	
    - [Grafana](https://grafana.com/) for building dashboards
- **Distributed Tracing**
    - Instrumenting microservices with a distributed tracing exporter
    - Accessing data collected on the distributed tracing server
    - [Zipkin platform](https://zipkin.io/)
        - [architecture](https://zipkin.io/pages/architecture.html)
        - [data model and API](https://zipkin.io/zipkin-api/#/default/post_spans)
        - [Brave Core Library](https://github.com/openzipkin/brave/blob/master/brave/README.md)
- **Distributed Logging** 
    - Instrumenting microservices with a logging adapter
    - Aggregating logs along a logging aggregation pipeline in to a Logging server/service
    - [ELK stack](https://www.elastic.co/elastic-stack), [quick info](https://aws.amazon.com/it/what-is/elk-stack/), [(Logstash in particular)](https://www.elastic.co/logstash)

		
		
		