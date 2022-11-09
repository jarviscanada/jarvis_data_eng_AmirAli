#! /bin/sh
cmd=$1
db_username=$2
db_password=$3
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
	docker volume ....
	docker run ....
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