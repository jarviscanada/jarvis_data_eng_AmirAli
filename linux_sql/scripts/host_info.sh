psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#parse info
lscpu_out=$(lscpu)
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "Model name:.*" | xargs | cut -d " " -f3-5)
cpu_mhz=$(echo "$lscpu_out" | egrep "CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out" | egrep "L2 cache:" | awk '{print $3}' | head -c-2 | xargs)
total_mem= $(grep MemTotal /proc/meminfo | awk '{print $2}' | xargs)
timestamp= $(vmstat -t | awk 'FNR == 3 {print $18,$19}')

#insert statement variable
#instert into db
#
