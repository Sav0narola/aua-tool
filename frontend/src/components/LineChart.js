import { PolarArea } from 'vue-chartjs';

export default PolarArea.extend({
  async mounted() {
    this.gradient = this.$refs.canvas.getContext('2d').createLinearGradient(0, 0, 0, 450);
    this.gradient2 = this.$refs.canvas.getContext('2d').createLinearGradient(0, 0, 0, 450);

    this.gradient.addColorStop(0, 'rgba(255, 0,0, 0.5)');
    this.gradient.addColorStop(0.5, 'rgba(255, 0, 0, 0.25)');
    this.gradient.addColorStop(1, 'rgba(255, 0, 0, 0)');

    this.gradient2.addColorStop(0, 'rgba(0, 231, 255, 0.9)');
    this.gradient2.addColorStop(0.5, 'rgba(0, 231, 255, 0.25)');
    this.gradient2.addColorStop(1, 'rgba(0, 231, 255, 0)');

    /*eslint-disable */

    //const myMonths = ['August', 'September', 'Oktober', 'November', 'Dezember'];
    //const values = [20, 23, 90, 25, 40];

    const APIURL = 'http://localhost:8080/boardsPerMonth';

    const returnJsonFromApi = await fetch(APIURL)
      .then(function(resp) {
        return resp.json();
      })
      .catch(function (error) {
        console.log(error);
      });

    var myKeys = new Array();
    var myValues = new Array();

    console.log(returnJsonFromApi);

    for (let [key, value] of Object.entries(returnJsonFromApi)) {
      console.log(key, value);
      myKeys.push(key);
      myValues.push(value);
    }

    this.renderChart({
      labels: myKeys,
      datasets: [
        {
          label: 'Created Boards per Month',
          borderColor: '#FC2525',
          pointBackgroundColor: 'white',
          borderWidth: 1,
          pointBorderColor: 'white',
          backgroundColor: this.gradient,
          data: myValues,
        }, {
          label: 'Source: Remote Retro-Tool',
          borderColor: '#05CBE1',
          pointBackgroundColor: 'white',
          pointBorderColor: 'white',
          borderWidth: 1,
          backgroundColor: this.gradient2,
          data: 0,
        },
      ],
    }, { reponsive: true, maintainAspectRatio: false });
  /*eslint-enable */ },
});
