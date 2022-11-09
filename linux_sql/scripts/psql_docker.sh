#! /bin/sh
cmd=$1
db_username=$2
db_password=$3
container_name="jrvs-psql"
sudo systemctl status docker || sudo systemctl start docker
docker container inspect jrvs-psql
container_status=$?
case $cmd in
  create)
  if [ $container_status -eq 0 ]; then
		echo 'Container already exists'
		exit 1
	fi
  if [ $# -ne 3 ]; then
    echo 'Create requires username and password'
    exit 1
  fi
  docker pull postgres
	docker volume create pgdata
	docker run --name $container_name -e POSTGRES_PASSWORD=$PGPASSWORD -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
	exit $?
	;;
  start|stop)
  if [ $container_status ...
  ...
	docker container $cmd jrvs-psql
	exit $?
	;;
  *)
	echo 'Illegal command'
	echo 'Commands: start|stop|create'
	exit 1
	;;
esac