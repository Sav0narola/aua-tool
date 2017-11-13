import { Bar } from 'vue-chartjs';

export default Bar.extend({
  mounted() {
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

    let data = fetch('http://localhost:8080/boardsPerMonth');

    let myKeys = Array;
    let myValues = Array;

    for (let [key, value] of Object.entries(data)) {
      console.log(key, value);
      myKeys.push(key);
      myValues.push(value);
    }

    console.log(myValues);

    this.renderChart({
      labels: myKeys, myValues,
      datasets: [
        {
          label: 'Created Boards per Month',
          borderColor: '#FC2525',
          pointBackgroundColor: 'white',
          borderWidth: 1,
          pointBorderColor: 'white',
          backgroundColor: this.gradient,
          data: myKeys,
        }, {
          label: 'Source: Remote Retro-Tool',
          borderColor: '#05CBE1',
          pointBackgroundColor: 'white',
          pointBorderColor: 'white',
          borderWidth: 1,
          backgroundColor: this.gradient2,
          data: myValues,
        },
      ],
    }, { reponsive: true, maintainAspectRatio: false });
  /*eslint-enable */ },
});
